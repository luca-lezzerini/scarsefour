import { Automa } from "./automa";
import { Event } from "./eventi";

export interface State {
    next(e: Event, a?: Automa);
}