import { Automa } from "./automa";

export interface State {
    next(e: Event, a?: Automa);
}