import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Hero from './components/Hero';
import Navbar from './components/Navbar';
import AdminLogin from './components/AdminLogin';
import AdminRegister from './components/AdminRegister';
import AdminNav from './AdminPage/AdminNav';
import AdminLanding from './AdminPage/AdminLanding';
import Footer from './components/Footer';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        
        <Routes>
          <Route path="/" element={[<Navbar />, <Hero />]}/>
          <Route path='/adminlogin' element={[<Navbar />, <AdminLogin />]}/>
          <Route path='/adminregister' element={[<Navbar />, <AdminRegister />]}/>
          <Route path='/adminlanding' element={[<AdminNav />, <AdminLanding />]}/>
        </Routes>
        <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
