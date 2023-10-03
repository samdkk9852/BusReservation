import React, { useState } from 'react'
import "../Styles/BusRegisteration.css"

const BusRegisteration = () => {
  const [busData, setBusData] = useState({
    name:"",
    bus_number:"",
    from:"",
    to:"",
    date_of_reg:"",
    bus_capacity: 0
  });

  const handleInputData=(event)=>{
    const {name, value} = event.target

    const updateData={
      ...busData,
      [name] : value,
    }
    setBusData(updateData)
    console.log(busData);
  }

  return (
    <div className='busregisteration'>
      <form action="" className='busform'>
        <h3>Enter Your Bus Details</h3>
        <input 
            type="text" 
            name='name'
            value={busData.name}
            onChange={handleInputData}
            placeholder='Enter Bus Name' 
        />
        <input 
            type="text" 
            name='bus_number'
            value={busData.bus_number}
            onChange={handleInputData}
            placeholder='Enter Bus Number' 
        />
        <input 
            type="text" 
            name='from'
            value={busData.from}
            onChange={handleInputData}
            placeholder='Departure Location'
        />
        <input 
            type="text" 
            name='to'
            value={busData.to}
            onChange={handleInputData}
            placeholder='Destination Location'
        />
        <input 
            type="date" 
            name='date_of_reg'
            value={busData.date_of_reg}
            onChange={handleInputData}
            placeholder='Date of Registeration'
        />
        <input 
            type="number" 
            name='bus_capacity'
            value={busData.bus_capacity}
            onChange={handleInputData}
            placeholder='Bus Capacity'
        />
        <button className='signUp__btn'> Register</button>
      </form>
    </div>
  )
}

export default BusRegisteration
