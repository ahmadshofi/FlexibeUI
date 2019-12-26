package com.ahmad.tugascl

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiHero {
    @GET("/radhikayusuf/static-api/master/superheroes.json")
    fun getHeros() : Observable<HeroResponse>
}