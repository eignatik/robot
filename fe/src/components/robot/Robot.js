import { Component } from "react";
import robot from '../../static/robot.png';
import './Robot.css';

class Robot extends Component {


    render() {
        return (
            <div className="robot">
                <div className="arrow arrow-up"></div>
                <img src={robot} alt="Yes, that's Robot"/>
            </div>
        );
    }

}

export default Robot;