import React from 'react'
import "../Styles/Footer.css"
import { Link } from 'react-router-dom'

const Footer = () => {
  return (
    <div className='footer'>
      <div className="footer__title">
        <h3>About redBus</h3>
      </div>
      <div className="footer__link">
        <Link>About us</Link>
        <Link>Contact us</Link>
        <Link>FAQ</Link>
        <Link>T&C</Link>
        <Link>Privacy policy</Link>
      </div>
      <div className="footer__rights">
        <p><small>Ⓒ 2023 Redbus India Pvt Ltd. All rights reserved</small></p>
      </div>

    </div>
  )
}

export default Footer
