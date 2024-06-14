package com.example.mars.fake

import com.example.mars.network.MarsApiService
import com.example.mars.network.MarsPhoto

class FakeMarsApiService : MarsApiService {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photoList
    }
}