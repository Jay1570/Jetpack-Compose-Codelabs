package com.example.mars

import com.example.mars.fake.FakeDataSource
import com.example.mars.fake.FakeNetworkMarsPhotosRepository
import com.example.mars.rules.TestDispatcherRule
import com.example.mars.ui.screens.MarsUiState
import com.example.mars.ui.screens.MarsViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MarsViewModelTest {

    @get :Rule
    val testDispatcher = TestDispatcherRule()
    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() =
        runTest {
            val marsViewModel = MarsViewModel(
                marsPhotosRepository = FakeNetworkMarsPhotosRepository()
            )
            assertEquals(
                MarsUiState.Success(FakeDataSource.photoList),
                marsViewModel.marsUiState
            )
        }
}