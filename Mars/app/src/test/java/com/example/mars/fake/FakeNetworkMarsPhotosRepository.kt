package com.example.mars.fake

import com.example.mars.data.MarsPhotosRepository
import com.example.mars.network.MarsPhoto

class FakeNetworkMarsPhotosRepository : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return FakeDataSource.photoList
    }
}