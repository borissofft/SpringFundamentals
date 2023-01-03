-- some test users

# INSERT INTO user_roles (id, user_role)
# values
#     (1, 'ADMIN'),
#     (2, 'USER');

INSERT INTO users (id, email, first_name, last_name, image_url, is_active, password)
VALUES
    (1, 'admin@example.com', 'Admin', 'Adminov', null, 1, '57e7759fd2d59275fc3c3cd5dd2ace5013b39ee972999412f3f5f5c3382b6765c2571ef86648abe2'),
    (2, 'user@example.com', 'User', 'Userov', null, 1, '57e7759fd2d59275fc3c3cd5dd2ace5013b39ee972999412f3f5f5c3382b6765c2571ef86648abe2');
