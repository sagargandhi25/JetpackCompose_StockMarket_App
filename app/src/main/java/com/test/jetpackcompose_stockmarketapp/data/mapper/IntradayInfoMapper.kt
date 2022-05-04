package com.test.jetpackcompose_stockmarketapp.data.mapper

import android.annotation.SuppressLint
import com.test.jetpackcompose_stockmarketapp.data.remote.dto.IntradayInfoDto
import com.test.jetpackcompose_stockmarketapp.domain.model.IntradayInfo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@SuppressLint("NewApi")
fun IntradayInfoDto.toIntradayInfo(): IntradayInfo {
    val pattern="yyyy-MM-dd HH:mm:ss"
    val formatter= DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    val localDateTime= LocalDateTime.parse(timestamp,formatter)
    return IntradayInfo(
        date = localDateTime,
        close= close
        )
}