import React from 'react'
import { createPortal } from 'react-dom'
import UserLogin from './UserLogin'

const UserPortal = () => {
  return (
    <div className='userportal'>
      {createPortal(<UserLogin />, document.body)}
    </div>
  )
}

export default UserPortal
