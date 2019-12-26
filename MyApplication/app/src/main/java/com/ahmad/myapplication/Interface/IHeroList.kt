package com.ahmad.myapplication.Interface

import retrofit2.http.GET

interface IHeroList {
    @get:GET("superheroes.json")
}