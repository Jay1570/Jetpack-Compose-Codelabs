package com.example.mars

import com.example.mars.data.NetworkMarsRepository
import com.example.mars.fake.FakeDataSource
import com.example.mars.fake.FakeMarsApiService
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkMarsRepositoryTest {
    @Test
    fun networkMarsRepository_getMarsPhotos_verifyPhotoList() =
        runTest {
            val repository = NetworkMarsRepository(
                marsApiService = FakeMarsApiService()
            )
            assertEquals(FakeDataSource.photoList, repository.getMarsPhotos())
        }
}
