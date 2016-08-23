import { Injectable } from '@angular/core';
import * as marked from 'marked';

interface MarkedConfig {
  sanitize?: boolean,
  gfm?: boolean,
  breaks?: boolean,
  smartypants?: boolean
}

@Injectable()
export class MarkedService {
  private md: MarkedStatic;

  constructor() {
    this.md = marked.setOptions({});
  }

  setConfig(config: MarkedConfig) {
    this.md = marked.setOptions(config);
  }

  parse(src: string): string {
    if(!src) {
      return '';
    }
    return this.md.parse(src);
  }

}