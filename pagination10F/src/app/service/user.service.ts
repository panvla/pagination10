import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApiResponse } from '../interface/api-response';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private readonly apiServerUrl = 'http://localhost:8080/api/v1/users';

  constructor(private http: HttpClient) {}

  users$ = (name: string = '', page: number = 0, size: number = 10) =>
    this.http.get<ApiResponse>(
      `${this.apiServerUrl}?name=${name}&page=${page}&size=${size}`
    );
}
