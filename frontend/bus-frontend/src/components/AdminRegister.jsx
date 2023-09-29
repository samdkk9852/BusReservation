import React, { useState } from 'react'
import "../Styles/AdminRegister.css"
import { Link, useNavigate } from 'react-router-dom'
import axios from 'axios'

const AdminRegister = () => {
const [adminData, setAdminData] = useState({
    name:"",
    email:"",
    phone:"",
    password:"",
    gst:""
})

const navigate = useNavigate();

    const handleInputData=(event)=>{
        const {name, value} = event.target;

        const updateData={
            ...adminData,
            [name] : value,
        }
        setAdminData(updateData)
        console.log(adminData);
    }

    const register=(event)=>{
        event.preventDefault()
        axios.post("http://localhost:8080/admin",adminData)
        .then(()=>{
            alert("submitted Successfully")
            navigate("/adminlogin")
        })
        .catch(()=>{
            alert("something went wrong!... try again")
        })
    }

  return (
    <div className='adminregister'>
      <form action="" className='registerform'>
        <h3>Admin Registeration</h3>
        <input
            type="text" 
            placeholder='Name' 
            name='name'
            value={adminData.name}
            onChange={handleInputData}
            required
        />
        <input 
            type="email" 
            placeholder='Email'
            name='email'
            value={adminData.email}
            onChange={handleInputData} 
            required
        />
        <input 
            type="tel" 
            pattern='[0-9]{10}'
            placeholder='Phone Number'
            name='phone'
            value={adminData.phone}
            onChange={handleInputData} 
            required
        />
        <input 
            type="password" 
            placeholder='Password' 
            name='password'
            value={adminData.password}
            onChange={handleInputData}
            required
        />
        <input 
            type="text" 
            placeholder='GST Number' 
            name='gst'
            value={adminData.gst}
            onChange={handleInputData}
            required
        />

        <button className='signUp__btn' onClick={register}>Register</button>
        <Link to="/adminlogin">Already have account...</Link>
      </form>
    </div>
  )
}

export default AdminRegister
