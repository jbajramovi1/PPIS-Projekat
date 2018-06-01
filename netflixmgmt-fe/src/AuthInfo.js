import React, { Component } from 'react';
import axios from "axios/index";


export default class AuthInfo {
    static getRole() {
        return localStorage.getItem("role")
    }
    static logout() {
        localStorage.removeItem("role")
        localStorage.removeItem("token")
        delete axios.defaults.headers["Authorization"]
    }
}
