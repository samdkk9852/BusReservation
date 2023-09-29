import React, { useState } from 'react'
import "../Styles/Navbar.css"
import { TbBus } from "react-icons/tb"
import {RiBus2Line} from "react-icons/ri"
import {CgProfile} from "react-icons/cg"
import {FaHeadset} from "react-icons/fa"
import {GrUserManager} from "react-icons/gr"
import { Link } from 'react-router-dom'

const Navbar = () => {
  // const [isDropdownOpen, setDropdownOpen] = useState(false);

  // const toggleDropdown=()=>{
  //   setDropdownOpen(!isDropdownOpen)
  // };

  return (
    <div className='navbar'>
      <div className="navbar__logo">
        <Link to="/">
          <img src="https://st.redbus.in/Images/rdc/rdc-redbus-logo.svg" alt="redbus" />
        </Link>
      </div>
      <div className="navbar__menu">
        <div className="navbar__menu__option">
            <TbBus size={27}/>
            <h3>Bus Tickets</h3>
        </div>
        <div className="navbar__menu__option">
            <RiBus2Line size={27}/>
            <h3>Bus Rental</h3>
        </div>
        <div className="navbar__menu__option">
            <Link className='navbar__menu__option_admin' to="/adminlogin">
              <GrUserManager size={27}/>
              <h3>Admin Login</h3>
            </Link>
        </div>
        <div>
          <Link to="/adminlanding">Admin-Page</Link>
        </div>
      </div>
      <div className="navbar__user">
        <div className="navbar__user__option">
          <FaHeadset size={27} fontVariant={100}/>
          <h3>Help</h3>
        </div>
        <div className="navbar__user__option">
          <CgProfile size={27} fontWeight={100}/>
            <div className='dropdown'>
              <span>Profile ▼</span>
            
              <ul className='dropdown__menu'>
                <li>Cancel Ticket</li>
                <li>Change Travel Date</li>
                <li>Show My Ticket</li>
                <li>Login/Signup</li>
              </ul>
          
          </div>
      </div>
      </div>
    </div>
  )
}

export default Navbar
