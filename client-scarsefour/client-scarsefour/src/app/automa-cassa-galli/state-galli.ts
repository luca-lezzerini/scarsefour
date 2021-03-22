import { Automa } from "./automa";
import { Event } from "./eventi-galli";


export interface State {
    next(e: Event, a?: Automa);
}