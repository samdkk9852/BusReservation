import React, { useState } from 'react'
import "../Styles/AdminLogin.css"
import { Link } from 'react-router-dom'
import axios from 'axios'

const AdminLogin = () => {
    const [adminData, setAdminData] = useState({
        email:"",
        password:""
    })

    const handleInput=(event)=>{
        const {name, value} = event.target;

        const updateInput = {
            ...adminData,
            [name] : value,
        }
        setAdminData(updateInput)
        console.log(adminData);
    }

    const login=(event)=>{
        event.preventDefault()

        let email = adminData.email;
        let password = adminData.password
        
        if(email.includes("@")){
            axios.get(`http://localhost:8080/admin/verifyemail?email=${email}&password=${password}`)
            .then((response)=>{
                localStorage.setItem("admin", JSON.stringify(response.data.data))
                alert("Login Successfull")

            })
            .catch((error)=>{
                alert("something went wrong!...")
                console.log(error);
            })
        }
        else{
            let phone = Number(email)
            axios.get(`http://localhost:8080/admin/verifyemail?email=${phone}&password=${password}`)
            .then((response)=>{
                localStorage.setItem("admin", JSON.stringify(response.data.data))
                alert("Login Successfull")

            })
            .catch((error)=>{
                alert("something went wrong!...")
                console.log(error);
            })
        }
    }
  return (
    <div className='adminlogin'>
        <h1>Access to millions of customers who book on redBus daily.</h1>
        <form action="" className='loginform'>
            <h3>Be part of world's largest bus booking platform</h3>
            <input 
                type="email" 
                name='email' 
                value={adminData.email} 
                placeholder='Enter Your Email/Phone' 
                onChange={handleInput}
            />
            <input 
                type="password" 
                name='password' 
                value={adminData.password} 
                placeholder='Enter Your Password' 
                onChange={handleInput}
            />
            <button className='signIn__btn' onClick={login}>Sign In</button>
            <Link to="/adminregister">
                <button className='signUp__btn'>Sign Up</button>
            </Link>
        </form>
    </div>
  )
}

export default AdminLogin
