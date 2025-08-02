import React, { useState } from "react";
import "./App.css";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => {
    setIsLoggedIn(true);
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
  };

  return (
    <div className="app-container">
      {!isLoggedIn ? (
        <div className="guest-view">
          <h1>Please sign up.</h1>
          <button className="login-btn" onClick={handleLogin}>
            Login
          </button>
        </div>
      ) : (
        <div className="user-view">
          <h1>Welcome back</h1>
          <button className="logout-btn" onClick={handleLogout}>
            Logout
          </button>
        </div>
      )}
    </div>
  );
}

export default App;
