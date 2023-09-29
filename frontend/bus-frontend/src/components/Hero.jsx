import React, { useState } from 'react'
import "../Styles/Hero.css"
import {MdOutlineDepartureBoard} from "react-icons/md"
import {MdOutlineDateRange} from "react-icons/md"
import {IoSwapHorizontalOutline} from "react-icons/io5"
import { DateField, LocalizationProvider, StaticDatePicker } from '@mui/x-date-pickers'
import {AdapterDayjs} from "@mui/x-date-pickers/AdapterDayjs"
import dayjs from 'dayjs'

const Hero = () => {
  const [date, setDate] = useState(dayjs("2022-04-17"))

  return (
    <div className='hero'>
      <h1>India's No. 1 Bus Ticket Booking Site</h1>
      <div className='searchbox'>
        <div className="searchbox__from searchbox__option">
          <MdOutlineDepartureBoard size={25}/>
          <input type="text" placeholder='From' />
        </div>
        <div className="searchbox__swap">
          <IoSwapHorizontalOutline size={25} />
        </div>
        <div className="searchbox__to searchbox__option">
          <MdOutlineDepartureBoard size={25} />
          <input type="text" placeholder='To' />
        </div>
        <div className="searchbox__date searchbox__option">
          <MdOutlineDateRange size={25} />
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DateField 
              label="Date"
              value={date}
              onChange={(newDate)=>{setDate(newDate)}}
              format='LL'
            />
            {/* <StaticDatePicker defaultValue={dayjs('2022-04-17')} /> */}
          </LocalizationProvider>
        </div>
        <div className="searchbox__searchbus searchbox__option">
          <button><h2>SEARCH BUSES</h2></button>
        </div>
      </div>
    </div>
  )
}

export default Hero
