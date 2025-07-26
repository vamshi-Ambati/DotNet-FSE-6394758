import "./Stylesheets/mystyle.css";
import CalculateScore from "./components/CalculateScore";

function App() {
  return (
    <div>
      <CalculateScore
        Name="vamshi"
        School="ZPHS"
        total={580}
        goal={600}
      />
    </div>
  );
}

export default App;
