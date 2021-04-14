import { Component } from 'react';
import Board from '../board/Board';
import ScriptInput from '../ScriptInput/ScriptInput';
import './App.css';

class App extends Component {
  constructor() {
    super();
    this.state = {
      robotPosition: {}
    }
    this.getPositionData = this.getPositionData.bind(this);
  }

  getPositionData(data) {
    this.setState({
      robotPosition: data.robotPosition
    });
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          Robot Operations
        </header>
        <div className="butter-bar">
          Welcome to v 0.1.
        </div>
        <div className="container">
          <div>
            <Board/>
          </div>
          <div>
            <ScriptInput positionCallback={this.getPositionData}/>
          </div>
          <div></div>
        </div>
      </div>
    );
  }
}

export default App;
