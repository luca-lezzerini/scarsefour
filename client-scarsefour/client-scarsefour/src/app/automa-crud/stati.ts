import { Automa } from "./automa";
import { Event1 } from "./eventi";

export interface State {
    next(e: Event1, a?: Automa);
}