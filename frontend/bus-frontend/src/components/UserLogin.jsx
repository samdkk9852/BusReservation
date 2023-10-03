import React from 'react'
import "../Styles/UserLogin.css"
import { Link } from 'react-router-dom'

const UserLogin = () => {
  return (
    <div className='userlogin'>
        <Link to="/"><button className='close__btn'>X</button></Link>
        <img src="https://st.redbus.in/Images/rdc/rdc-redbus-logo.svg" alt="redbus" />
        <h2>Sign in to avail exciting discounts and cashbacks!!</h2>
      <form action="" className='userform'>
        <h3>User Login</h3>
        <input 
            type="email" 
            placeholder='Enter your Email/Phone' 
        />
        <input 
            type="password" 
            placeholder='Enter your Password'
        />
        <button className='signIn__btn'>Sign In</button>
        <button className='signUp__btn'>Sign Up</button>
      </form>
    </div>
  )
}

export default UserLogin
