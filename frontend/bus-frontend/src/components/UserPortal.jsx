import React from 'react'
import "../Styles/UserPortal.css"
import { createPortal } from 'react-dom'
import UserLogin from './UserLogin'
import { useNavigate } from 'react-router-dom'

const UserPortal = () => {
  const navigate = useNavigate();

  const handleClick=()=>{
    navigate("/")
  }
  return (
    <>
      <div className='modal-wrapper' onClick={handleClick}></div>
      <div className='modal-container'>
      {createPortal(<UserLogin />, document.body)}
        {/* <UserLogin /> */}
      </div>
    </>
  )
}

export default UserPortal
