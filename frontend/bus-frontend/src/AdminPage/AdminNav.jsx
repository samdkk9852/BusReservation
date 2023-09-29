import React from 'react'
import "../Styles/AdminNav.css"
import { Link } from 'react-router-dom'

const AdminNav = () => {
  return (
    <div className='adminnav'>
      <div className="adminnav__left">
        <Link to="/"><img src="https://onboardvendor.redbus.in/resources/Logo.svg" alt="" /></Link>
        <h3>My Bus on redBus</h3>
      </div>
      <div className="adminnav__center">
        <Link ><h3>Add Bus</h3></Link>
      </div>
      <div className="adminnav__right">
        <h3>English</h3>
        <h3>தமிழ்</h3>
        <h3>हिन्दी</h3>
      </div>
    </div>
  )
}

export default AdminNav
