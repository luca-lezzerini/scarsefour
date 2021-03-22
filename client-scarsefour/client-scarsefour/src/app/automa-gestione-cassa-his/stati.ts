import { AutomaCassa } from "./automa";
import { Event } from "../automa-crud/eventi";
export interface StateCassa {
    next(e: Event, a?: AutomaCassa);
}