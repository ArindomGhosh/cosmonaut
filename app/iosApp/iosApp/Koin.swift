//
//  Koin.swift
//  iosApp
//
//  Created by Arindom Ghosh on 19/12/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import shared

// https://medium.com/@uwaisalqadri/elegant-koin-injection-for-swift-in-kotlin-multiplatform-mobile-9a803f6efb2e

typealias KoinApplication = Koin_coreKoinApplication

typealias Koin = Koin_coreKoin

extension KoinApplication {
    static let shared = companion.start()
    
    @discardableResult
    static func start() -> KoinApplication {
        shared
    }
}

extension KoinApplication{
    private static let keyPaths: [PartialKeyPath<Koin>]=[
        \.getLaunchesUseCase
    ]
    
    static func inject<T>()-> T{
        shared.inject()
    }
    
    func inject<T>()->T{
        for partialPathKey in Self.keyPaths{
            guard let keyPath = partialPathKey as? KeyPath<Koin, T> else {continue}
            return koin[keyPath: keyPath]
        }
        fatalError("\(T.self) not registered with KoinApplication")
    }
}


@propertyWrapper
struct LazyKoin<T>{
    lazy var wrappedValue:T = {KoinApplication.shared.inject()}()
    
    init(){ }
}
