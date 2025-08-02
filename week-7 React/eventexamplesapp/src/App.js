import React, { useState } from "react";
import "./App.css";

function App() {
  const [count, setCount] = useState(0);
  const [message, setMessage] = useState("");
  const [clickMessage, setClickMessage] = useState("");
  const [euroValue, setEuroValue] = useState("");
  const [rupeeValue, setRupeeValue] = useState("");

  const incrementCounter = () => {
    setCount((prevCount) => prevCount + 1);
  };

  const sayHello = () => {
    setMessage("Hello! This is a static message from the Increase button.");
  };

  const handleIncrement = () => {
    incrementCounter();
    sayHello();
  };

  const handleDecrement = () => {
    setCount((prevCount) => prevCount - 1);
    setMessage("");
  };

  const greetUser = (greeting) => {
    setMessage(`${greeting} to our Event Examples App!`);
  };

  const handleClick = (e) => {
    setClickMessage("I was clicked");
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (euroValue) {
      const convertedValue = parseFloat(euroValue) * 90;
      setRupeeValue(convertedValue.toFixed(2));
    }
  };

  return (
    <div className="App">
      <h1>Event Handling Examples</h1>

      <div className="section">
        <h2>Counter Example</h2>
        <p>Current Count: {count}</p>
        <div className="button-group">
          <button onClick={handleIncrement}>Increase</button>
          <button onClick={handleDecrement}>Decrease</button>
        </div>
        {message && <p className="message">{message}</p>}
      </div>

      <div className="section">
        <h2>Button with Argument</h2>
        <button onClick={() => greetUser("Welcome")}>Say Welcome</button>
      </div>

      <div className="section">
        <h2>Synthetic Event</h2>
        <button onClick={handleClick}>Click Me</button>
        {clickMessage && <p className="message">{clickMessage}</p>}
      </div>

      <div className="section">
        <h2>Currency Convertor</h2>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>
              Euro:
              <input
                type="number"
                value={euroValue}
                onChange={(e) => setEuroValue(e.target.value)}
                placeholder="Enter amount in Euro"
              />
            </label>
          </div>
          <button type="submit">Convert to Rupees</button>
          {rupeeValue && (
            <p className="result">
              ₹{rupeeValue} (€{euroValue})
            </p>
          )}
        </form>
      </div>
    </div>
  );
}

export default App;
