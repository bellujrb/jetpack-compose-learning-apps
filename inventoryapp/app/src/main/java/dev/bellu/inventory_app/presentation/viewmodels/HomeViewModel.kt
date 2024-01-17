package dev.bellu.inventory_app.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bellu.inventory_app.data.database.InventoryDatabase
import dev.bellu.inventory_app.data.entity.ItemEntity
import dev.bellu.inventory_app.presentation.screens.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val db: InventoryDatabase) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun fetchDataFromDatabase() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                itemList = db.itemDao().getAll()
            )
        }
    }

    suspend fun addItem(name: String, price: String, stock: String) {

        val addItemEntity = ItemEntity(
            name = name,
            price = price.toDouble(),
            stock = stock.toInt()
        )

        db.itemDao().insert(addItemEntity)
        _uiState.value = _uiState.value.copy(
            itemList = db.itemDao().getAll(),
            isBottomSheetVisible = !_uiState.value.isBottomSheetVisible
        )
    }

    suspend fun updateItem(newPrice: Double, newStock: Int){

        val updateItemEntity = ItemEntity(
            id = _uiState.value.actualItem.id,
            name = _uiState.value.actualItem.name,
            price = newPrice,
            stock = newStock
        )

        db.itemDao().update(updateItemEntity)
        _uiState.value = _uiState.value.copy(
            itemList = db.itemDao().getAll(),
            actualItem = updateItemEntity,
            isShowModalUpdate = !_uiState.value.isShowModalUpdate
        )
    }

    suspend fun removeItem(itemEntity: ItemEntity) {
        db.itemDao().delete(itemEntity)

        _uiState.value = _uiState.value.copy(
            itemList = db.itemDao().getAll(),
            isShowModal = !uiState.value.isShowModal
        )
    }

    fun changeActualItem(itemEntity: ItemEntity){
        _uiState.value = _uiState.value.copy(
            actualItem = itemEntity,
            isShowModal = !uiState.value.isShowModal
        )
    }

    fun changeStatusBottom() {
        _uiState.value = _uiState.value.copy(
            isBottomSheetVisible = !_uiState.value.isBottomSheetVisible
        )
    }


    fun changeStateModal() {
        _uiState.value = _uiState.value.copy(
            isShowModal = !_uiState.value.isShowModal
        )
    }

    fun changeStateModalUpdate(){
        changeStateModal()
        _uiState.value = _uiState.value.copy(
            isShowModalUpdate = !_uiState.value.isShowModalUpdate
        )
    }

    fun cancelAction(){
        _uiState.value = _uiState.value.copy(
            isShowModal = false,
            isShowModalUpdate = false
        )
    }

}