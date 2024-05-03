package com.example.app30dias.Data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.app30dias.R

data class DaysData(
    @StringRes val tittle : Int,
    @StringRes val name: Int,
    @StringRes val content : Int,
    val number_day : Int ,
    @DrawableRes val pic : Int

    )



val datList = listOf(
    DaysData(R.string.Day, R.string.day1subtitle, R.string.day1Content, 1,R.drawable.day1image),
    DaysData(R.string.Day, R.string.day2subtitle, R.string.day2Content, 2, R.drawable.day2image),
    DaysData(R.string.Day, R.string.day3subtitle, R.string.day3Content, 3, R.drawable.day3image),
    DaysData(R.string.Day, R.string.day4subtitle, R.string.day4Content, 4, R.drawable.day4image),
    DaysData(R.string.Day, R.string.day5subtitle, R.string.day5Content, 5, R.drawable.day5image),
    DaysData(R.string.Day, R.string.day6subtitle, R.string.day6Content, 6, R.drawable.day6image),
    DaysData(R.string.Day, R.string.day7subtitle, R.string.day7Content, 7, R.drawable.day7image),
    DaysData(R.string.Day, R.string.day8subtitle, R.string.day8Content, 8, R.drawable.day8image),
    DaysData(R.string.Day, R.string.day9subtitle, R.string.day9Content, 9, R.drawable.day9image),
    DaysData(R.string.Day, R.string.day10subtitle, R.string.day10Content, 10, R.drawable.day10image),
    DaysData(R.string.Day, R.string.day11subtitle, R.string.day11Content, 11, R.drawable.day11image),
    DaysData(R.string.Day, R.string.day12subtitle, R.string.day12Content, 12, R.drawable.day12image),
    DaysData(R.string.Day, R.string.day13subtitle, R.string.day13Content, 13, R.drawable.day13image),
    DaysData(R.string.Day, R.string.day14subtitle, R.string.day14Content, 14, R.drawable.day14image),
    DaysData(R.string.Day, R.string.day15subtitle, R.string.day15Content, 15, R.drawable.day15image),
    DaysData(R.string.Day, R.string.day16subtitle, R.string.day16Content, 16, R.drawable.day16image),
    DaysData(R.string.Day, R.string.day17subtitle, R.string.day17Content, 17, R.drawable.day17image),
    DaysData(R.string.Day, R.string.day18subtitle, R.string.day18Content, 18, R.drawable.day18image),

)