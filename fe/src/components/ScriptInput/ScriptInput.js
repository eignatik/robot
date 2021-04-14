import { Component } from "react";
import './ScriptInput.css';

class ScriptInput extends Component {

    constructor() {
        super();
        this.state = {
            scriptAreaValue: "",
            errorMessage: ""
        }
        this.handleSubmit = this.handleSubmit.bind(this);
        this.sendData = this.sendData.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        const script = this.state.scriptAreaValue;
        if (script === "") {
            this.setState({errorMessage: "Please enter script. Script cannot be empty."});
            return;
        }
        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'text/plain', 'Accept':'*/*', 'Connection':'keep-alive'},
            body: this.state.scriptAreaValue
        };
        fetch('http://localhost:3000/apply-script', requestOptions)
            .then(async response => {
                const data = await response.json();
                if (!response.ok) {
                    const error = (data && data.message) || response.status;
                    return Promise.reject(error);
                }
                this.sendData(data);
                this.setState({errorMessage: ""});
            })
            .catch(error => {
                this.setState({errorMessage: error});
                console.error(error);
            });
    }

    sendData(data) {
        this.props.positionCallback(data);
    }

    handleChange(event) {
        this.setState({scriptAreaValue: event.target.value});
    }

    render() {
        const error = this.state.errorMessage;
        let errorMessage;
        if (error) {
            errorMessage = <div className="error-log"><span className="error-message">{error}</span></div>
        }
        return(
            <div>                
                <form className="script-input" onSubmit={this.handleSubmit}>
                    <div><textarea value={this.state.scriptAreaValue} onChange={this.handleChange} placeholder="Enter commands..."/></div>
                    <div><input type="submit" value="Apply" /></div>
                </form>
                {errorMessage}
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
                    <p>Please use Enter/Return to separate commands.</p>
                </div>
            </div>
        )
    }
}

export default ScriptInput;