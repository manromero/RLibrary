/**
 * Created by manromero on 07/11/2017.
 */
export interface FileReaderEvent extends Event {
  target: FileReaderEventTarget;
  getMessage(): string;
}

interface FileReaderEventTarget extends EventTarget {
  result: string;
}
