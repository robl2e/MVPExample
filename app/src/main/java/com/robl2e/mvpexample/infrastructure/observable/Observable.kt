package com.robl2e.mvpexample.infrastructure.observable

import java.util.*
import java.util.concurrent.ConcurrentHashMap

interface Observable<LISTENER> {
    fun registerListener(listener: LISTENER)
    fun unregisterListener(listener: LISTENER)
    fun getListeners(): Set<LISTENER>

    interface Factory {
        companion object {
            fun <LISTENER> create() : Observable<LISTENER>{
                return ObservableImpl()
            }
        }
    }
}


internal class ObservableImpl<LISTENER> : Observable<LISTENER> {
    // thread-safe set of listeners
    private val listeners = Collections.newSetFromMap(
            ConcurrentHashMap<LISTENER, Boolean>(1))


    override fun registerListener(listener: LISTENER) {
        listeners.add(listener)
    }

    override fun unregisterListener(listener: LISTENER) {
        listeners.remove(listener)
    }

    override fun getListeners(): Set<LISTENER> {
        return Collections.unmodifiableSet(listeners)
    }
}