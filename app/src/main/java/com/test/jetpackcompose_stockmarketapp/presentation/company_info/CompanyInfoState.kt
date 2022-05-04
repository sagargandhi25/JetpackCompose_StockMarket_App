package com.test.jetpackcompose_stockmarketapp.presentation.company_info

import com.test.jetpackcompose_stockmarketapp.domain.model.CompanyInfo
import com.test.jetpackcompose_stockmarketapp.domain.model.IntradayInfo

data class CompanyInfoState(
    val stockInfo: List<IntradayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
