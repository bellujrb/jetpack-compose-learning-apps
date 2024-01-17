package dev.bellu.inventory_app.presentation.screens

import dev.bellu.inventory_app.data.entity.ItemEntity

data class HomeUiState(
    val itemList: List<ItemEntity> = emptyList(),
    val actualItem: ItemEntity = ItemEntity(id = 0, name = "", price = 0.0, stock = 0),
    val isShowModal: Boolean = false,
    val isShowModalUpdate: Boolean = false,
    val isBottomSheetVisible: Boolean = false
)
