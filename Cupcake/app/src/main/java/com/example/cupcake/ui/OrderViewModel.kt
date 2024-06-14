package com.example.cupcake.ui

import androidx.lifecycle.ViewModel
import com.example.cupcake.data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

private const val PRICE_PER_CUPCAKE = 2.00
private const val PRICE_FOR_SAME_DAY_PICKUP = 3.00

class OrderViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(OrderUiState(pickUpOptions = pickUpOptions()))
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    fun setQuanity(quantity: Int) {
        _uiState.update {currentState ->
            currentState.copy(
                quantity = quantity,
                price = calculatePrice(quantity = quantity)
            )
        }
    }

    fun setFlavour(desiredFlavour: String) {
        _uiState.update {currentState ->
            currentState.copy(flavour = desiredFlavour)
        }
    }

    fun setDate(date: String) {
        _uiState.update { currentState ->
            currentState.copy(date = date, price = calculatePrice(pickUpDate = date))
        }
    }

    fun resetOrder() {
        _uiState.value = OrderUiState(pickUpOptions = pickUpOptions())
    }

    private fun calculatePrice(
        quantity: Int = uiState.value.quantity,
        pickUpDate: String = uiState.value.date
    ): String {
        var price = quantity * PRICE_PER_CUPCAKE
        if (pickUpOptions()[0] == pickUpDate) {
            price += PRICE_FOR_SAME_DAY_PICKUP
        }
        val formattedPrice = NumberFormat.getCurrencyInstance().format(price)
        return formattedPrice
    }

    private fun pickUpOptions(): List<String> {
        val dateOptions = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4) {
            dateOptions.add(formatter.format(calendar.time))
        calendar.add(Calendar.DATE, 1)
        }
        return dateOptions
    }
}