package com.test.jetpackcompose_stockmarketapp.presentation.company_listing

import com.test.jetpackcompose_stockmarketapp.domain.model.CompanyListing

data class CompanyListingsState(
    val companies: List<CompanyListing> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
