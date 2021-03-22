import { AutomaCassa } from "./automa-ill";
import { Event } from "./eventi-ill";

export interface State {
    next(e: Event, a?: AutomaCassa);
}