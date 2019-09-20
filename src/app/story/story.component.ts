import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Story } from '../story';

@Component({
  selector: 'app-story',
  templateUrl: './story.component.html',
  styleUrls: ['./story.component.css']
})
export class StoryComponent implements OnInit {

  myresponse: any;

  @Input()
  story: Story;

  constructor(
    private http: HttpClient
  ) { }

  ngOnInit() {
  }

  addLike(story: Story) {
    story.numLikes = story.numLikes + 1;
    this.http.put('http://localhost:9005/P2FB_Application/updatestory', JSON.stringify(story)).subscribe(
      data => {
      },
      error => {
        console.log('Error Occured:' + error);
        alert('Like failed');
      }
    );
  }
}
