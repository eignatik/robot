import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        Robot Operations
      </header>
      <div>

        <div class=""> </div>

        <table className="board">
            <tbody>
                <tr>
                    <th></th>
                    <th>1</th>
                    <th>2</th>
                    <th>3</th>
                    <th>4</th>
                    <th>5</th>
                </tr>
                <tr>
                    <th>1</th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <th>2</th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <th>3</th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <th>4</th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <th>5</th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
      </div>
      <div>
        <div>Enter moving script in the field below (separate commands by new lines)</div>
        <textarea cols="50" rows="20" placeholder="Enter commands..."/>
        <div className="supported-commands">
            <h3>Supported commands.</h3>
            <ul>
                <li><b>POSITION X Y NORTH|EAST|SOUTH|WEST</b> - sets an initial position of the robot (X and Y coordinates from 1 to 5; Select one of directions;</li>
                <li><b>FORWARD N</b> - moves the robot on N steps (it is moving in the direction it looks)</li>
                <li><b>TURNAROUND</b> - 180 degrees turn</li>
                <li><b>LEFT</b> - turns once anti-clockwise</li>
                <li><b>RIGHT</b> - turns once clockwise </li>
                <li><b>WAIT</b> - does nothing</li>
            </ul>
        </div>
      </div>
    </div>
  );
}

export default App;
