//
//  FlowUtill.swift
//  iosApp
//
//  Created by Arindom Ghosh on 30/12/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import shared

class FlowCollector<T>:Kotlinx_coroutines_coreFlowCollector{
    let callback:(T) -> Void

    init(callback: @escaping (T) -> Void) {
        self.callback = callback
    }

    func emit(value: Any?, completionHandler: @escaping (Error?) -> Void) {
        // do whatever you what with the emitted value
        callback(value as! T)
        // after you finished your work you need to call completionHandler to
        // tell that you consumed the value and the next value can be consumed,
        // otherwise you will not receive the next value
        //
        // i think first parameter can be always nil or KotlinUnit()
        // second parameter is for an error which occurred while consuming the value
        // passing an error object will throw a NSGenericException in kotlin code, which can be handled or your app will crash
        completionHandler(nil)
    }

}
