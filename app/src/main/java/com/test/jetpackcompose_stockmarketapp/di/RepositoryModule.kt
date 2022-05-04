package com.test.jetpackcompose_stockmarketapp.di

import com.test.jetpackcompose_stockmarketapp.data.csv.CSVParser
import com.test.jetpackcompose_stockmarketapp.data.csv.CompanyListingParser
import com.test.jetpackcompose_stockmarketapp.data.csv.IntradayInfoParser
import com.test.jetpackcompose_stockmarketapp.data.repository.StockRepositoryImpl
import com.test.jetpackcompose_stockmarketapp.domain.model.CompanyListing
import com.test.jetpackcompose_stockmarketapp.domain.model.IntradayInfo
import com.test.jetpackcompose_stockmarketapp.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingParser: CompanyListingParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository

    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser(
        intradayInfoParser: IntradayInfoParser
    ): CSVParser<IntradayInfo>
}