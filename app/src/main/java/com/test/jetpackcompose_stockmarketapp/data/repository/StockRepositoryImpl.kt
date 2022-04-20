package com.test.jetpackcompose_stockmarketapp.data.repository

import com.opencsv.CSVReader
import com.test.jetpackcompose_stockmarketapp.data.local.StockDatabase
import com.test.jetpackcompose_stockmarketapp.data.mapper.toCompanyListing
import com.test.jetpackcompose_stockmarketapp.data.remote.StockApi
import com.test.jetpackcompose_stockmarketapp.domain.model.CompanyListing
import com.test.jetpackcompose_stockmarketapp.domain.repository.StockRepository
import com.test.jetpackcompose_stockmarketapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    val api: StockApi,
    val db: StockDatabase
): StockRepository {

    private val dao = db.dao
    override suspend fun getCompanyListing(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
       return flow {
           emit(Resource.Loading(true))
           val localListings = dao.searchCompanyListing(query)
           emit(Resource.Success(
               data = localListings.map { it.toCompanyListing() }
           ))
           val isDbEmpty = localListings.isEmpty() && query.isBlank()
           val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
           if(shouldJustLoadFromCache) {
               emit(Resource.Loading(false))
               return@flow
           }
           val remoteListing = try {
                val response = api.getListings()
           } catch (e: IOException) {
               e.printStackTrace()
               emit(Resource.Error("Couldn't load data"))
           } catch (e: HttpException) {
               e.printStackTrace()
               emit(Resource.Error("Couldn't load data"))
           }
       }
    }
}