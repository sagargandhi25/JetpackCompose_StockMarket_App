package com.test.jetpackcompose_stockmarketapp.domain.repository

import com.test.jetpackcompose_stockmarketapp.data.local.CompanyListingEntity
import com.test.jetpackcompose_stockmarketapp.domain.model.CompanyListing
import com.test.jetpackcompose_stockmarketapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListing(
    fetchFromRemote: Boolean,
    query: String
    ): Flow<Resource<List<CompanyListing>>>
}