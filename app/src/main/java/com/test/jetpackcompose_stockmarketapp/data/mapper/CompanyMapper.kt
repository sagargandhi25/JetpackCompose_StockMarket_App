package com.test.jetpackcompose_stockmarketapp.data.mapper

import com.test.jetpackcompose_stockmarketapp.data.local.CompanyListingEntity
import com.test.jetpackcompose_stockmarketapp.data.remote.dto.CompanyInfoDto
import com.test.jetpackcompose_stockmarketapp.domain.model.CompanyInfo
import com.test.jetpackcompose_stockmarketapp.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: ""
    )
}
