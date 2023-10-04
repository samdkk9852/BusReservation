import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Hero from './components/Hero';
import Navbar from './components/Navbar';
import AdminLogin from './components/AdminLogin';
import AdminRegister from './components/AdminRegister';
import AdminNav from './AdminPage/AdminNav';
import AdminLanding from './AdminPage/AdminLanding';
import Footer from './components/Footer';
import Map from './components/Map';
import UserLogin from './components/UserLogin';
import UserPortal from './components/UserPortal';
import BusRegisteration from './AdminPage/BusRegisteration';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        
        <Routes>
          <Route path="/" element={[<Navbar />, <Hero />, <Map />]}/>
          <Route path='/adminlogin' element={[<Navbar />, <AdminLogin />]}/>
          <Route path='/adminregister' element={[<Navbar />, <AdminRegister />]}/>
          <Route path='/adminlanding' element={[<AdminNav />, <AdminLanding />]}/>
          <Route path='/busregisteration' element={[<AdminNav />, <BusRegisteration />]}/>
          {/* <Route path='/userlogin' element={<UserLogin />} /> */}
          <Route path='/userportal' element={[<Navbar />, <Hero />, <Map />, <UserPortal />]} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
