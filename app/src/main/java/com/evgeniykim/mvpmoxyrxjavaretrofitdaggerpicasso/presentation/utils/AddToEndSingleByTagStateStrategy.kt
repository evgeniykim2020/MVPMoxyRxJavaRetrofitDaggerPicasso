package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.presentation.utils

import moxy.MvpView
import moxy.viewstate.ViewCommand
import moxy.viewstate.strategy.StateStrategy

class AddToEndSingleByTagStateStrategy: StateStrategy {
    override fun <View : MvpView?> beforeApply(
        currentState: MutableList<ViewCommand<View>>?,
        incomingCommand: ViewCommand<View>?
    ) {
        val iterator = currentState?.iterator()

        if (iterator != null) {
            while (iterator.hasNext()) {
                val entry = iterator.next()

                if (incomingCommand != null) {
                    if (entry.tag.equals(incomingCommand.tag)) {
                        iterator.remove()
                        break
                    }
                }
            }
        }
        if (incomingCommand != null) {
            if (currentState != null) {
                currentState.add(incomingCommand)
            }
        }
    }

    override fun <View : MvpView?> afterApply(
        currentState: MutableList<ViewCommand<View>>?,
        incomingCommand: ViewCommand<View>?
    ) {

    }
}