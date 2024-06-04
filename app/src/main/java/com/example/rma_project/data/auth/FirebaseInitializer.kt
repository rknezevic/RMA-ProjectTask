package com.example.rma_project.data.auth

import com.google.firebase.auth.FirebaseAuth

object FirebaseInitializer {

    private var isInitialized = false
    lateinit var firebaseAuth: FirebaseAuth

    fun initializeFirebase() {
        if (!isInitialized) {
            firebaseAuth = FirebaseAuth.getInstance()
            isInitialized = true
        }
    }
}