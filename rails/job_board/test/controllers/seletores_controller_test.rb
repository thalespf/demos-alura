require 'test_helper'

class SeletoresControllerTest < ActionController::TestCase
  test "should get tipos" do
    get :tipos
    assert_response :success
  end

end
